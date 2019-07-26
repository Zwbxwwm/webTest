package com.example.test.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.test.Drools.PointRuleEngine;
import com.example.test.Drools.PointRuleEngineImpl;
import com.example.test.Service.IOrderService;
import com.example.test.common.Response;
import com.example.test.config.didiConfig;
import com.example.test.dao.didiOrderRepository;
import com.example.test.dao.didiUserRepository;
import com.example.test.entity.didiOrder;
import com.example.test.entity.didiUser;
import com.example.test.utils.DESUtil;
import com.example.test.utils.HttpRequestUtil;
import org.kie.api.cdi.KSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private didiOrderRepository didiOrderRepository;

    @Autowired
    private didiUserRepository didiUserRepository;

    @Autowired
    private didiConfig didiConfig;

    @Autowired
    private PointRuleEngine pointRuleEngine;

    @Value("${didi.url1}")
    private String CREATE_ORDER_URL;

    @Value("${didi.clientId}")
    private String CLIENT_ID;

    @Value("${didi.clientSecret}")
    private String CLIENT_SECRET;

    @Value("${didi.masterPhone}")
    private String MASTER_PHONE;

    @Value("${didi.key}")
    private String KEY;



    @Override
    //请求订单号和ticket
    public String create(String passengerPhone) throws Exception {
        //封装DES加密的map
        Map origin = new HashMap();
        origin.put("client_id",CLIENT_ID);
        origin.put("client_secret",CLIENT_SECRET);
        origin.put("master_phone",MASTER_PHONE);
        origin.put("passenger_phone",passengerPhone);
        origin.put("auth_type","1");
        String dataEncode = DESUtil.encrypt(JSON.toJSONString(origin),KEY);


        //封装请求的参数
        Map param  = new HashMap();
        param.put("client_id",CLIENT_ID);
        param.put("data_encode",dataEncode);
        String param2 = JSON.toJSONString(param);

        //获取第三方接口返回值
        String result = HttpRequestUtil.doPostForJson(CREATE_ORDER_URL,param2);
        JSONObject jsonObject = JSON.parseObject(result);

        String ticket = (String)jsonObject.get("ticket");

        //将orderId存入数据库
        didiOrder didiOrder = new didiOrder();
        String orderId = (String) jsonObject.get("order_id");
        if(orderId != didiOrderRepository.findByOrderId(orderId).getOrderId()){
            didiOrder.setPassengerPhone(passengerPhone);
            didiOrder.setAdminPhone(MASTER_PHONE);
            didiOrder.setOrderId(orderId);
            didiOrderRepository.save(didiOrder);
        }else{
            throw  new Exception("【订单模块】—>该订单已存在");
        }

        return ticket;
    }


    //drools测试
    public String testDrools(String OrderId){
        didiOrder order = new didiOrder();
        Response response = new Response();
        pointRuleEngine.initEngine();
        order.setOrderId(OrderId);
        pointRuleEngine.executeRuleEngine(order);
        return order.getOrderId()+response.getData();
    }


    //事务管理测试
    @Transactional
    public void test(String param){
        didiUser didiUser = new didiUser();
        didiUser.setPassengerPhone(param);
        didiUser.setPassengerPassword("11221");
        didiUserRepository.save(didiUser);

        didiOrder didiOrder = new didiOrder();
        didiOrder.setOrderId(param);
        didiOrder.setPassengerPhone("11221");
        didiOrder.setAdminPhone(MASTER_PHONE);

        didiOrderRepository.save(didiOrder);

    }
}
