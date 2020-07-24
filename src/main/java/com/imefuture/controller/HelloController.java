package com.imefuture.controller;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class HelloController {
//    private static int count = 10000;
    private static ConcurrentHashMap<String, EnterpriseConfig> enter = new ConcurrentHashMap<>();
    static {
        for (int i = 0; i < 10; i++) {
            EnterpriseConfig config = new EnterpriseConfig();
//            switch (i % 3) {
//                case 0:
//                    config.setAuthType(EnterpriseConfig.AuthType.IP);
//                    break;
//                case 1:
//                    config.setAuthType(EnterpriseConfig.AuthType.MD5);
//                    break;
//                case 2:
//                    config.setAuthType(EnterpriseConfig.AuthType.UNLIMITED);
//                    break;
//            }
            config.setAuthType(EnterpriseConfig.AuthType.MD5);
            if (config.getAuthType() == EnterpriseConfig.AuthType.IP) {
//                if (i % 2 == 1) {
//                    config.setIps("|0.0.0.0|127.0.0.1|");
//                } else {
                    config.setIps("|192.168.3.61|127.0.0.1|");
//                }
            }
            config.setSecret(UUID.randomUUID().toString().replaceAll("-", ""));
            config.setSerialNo(UUID.randomUUID().toString());
            enter.put(config.getSerialNo(), config);
        }

    }

    @GetMapping("xxxx")
    public void xxxx() {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1; i++) {
            int finalI = i;
            executorService.submit(() -> {
                EnterpriseConfig enterpriseConfig = randomMap(enter);
                if (finalI % 2 == 0) {
//                    get(enterpriseConfig);
                    put(enterpriseConfig);

                } else {
//                    get(enterpriseConfig);
                    put(enterpriseConfig);
                }
            });
        }
    }
    public void get(EnterpriseConfig enterpriseConfig) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//                headers.add("sign", "");
        HashMap<String, String[]> paramMap = new HashMap<>();
        paramMap.put("enterprise_no", new String[]{enterpriseConfig.getSerialNo()});
        paramMap.put("order_operate_id", new String[]{"297ed1ae7356e76c017356ff05740016"});
        String signData = getSignData(paramMap);


        String sign = generatorMd5Header(signData, enterpriseConfig.getSecret());
        headers.add("sign", sign);
        ResponseEntity<HashMap> exchange = restTemplate.exchange("http://192.168.3.61:8089/nonstandard-core/erp/V1/getInspectOrder?" + signData, HttpMethod.GET, /*携带header*/new HttpEntity<String>(headers), HashMap.class);
        HashMap<String, Object> body = exchange.getBody();
        if (!body.get("data").equals(enterpriseConfig.getSerialNo()) && !body.get("data").equals("无权访问")&& !body.get("data").equals("参数错误")) {
            System.err.println(enterpriseConfig + "  " + body);
        } else {
            System.out.println(enterpriseConfig + "  " + body);
        }
    }
    public void put(EnterpriseConfig enterpriseConfig) {
        RestTemplate restTemplate = new RestTemplate();

        String param = "{\"memberId\":null,\"pager\":null,\"cmpName\":null,\"enterprise_no\":\""+enterpriseConfig.getSerialNo()+"\",\"entity\":{\"purchaseProjectInfos\":[{\"sourceNo\":null,\"productionBatch\":null,\"batchIndex\":null,\"bomAccId\":\"8aaedd0e6bb239fc016bcf19361d191f\",\"oldBomAccId\":\"8aaedd0e6897d7b501692dfb8f072369\",\"versionId\":null,\"accSource\":null,\"label\":null,\"deliveryDate\":\"2019-01-24\",\"partNumber\":\"MBGO-1901-015-01-001\",\"partName\":\"检测销\",\"materialNumber\":\"C03513011\",\"referenceNum\":\"1.0\",\"referPrice\":30.17,\"materialName2\":null,\"customTags\":null,\"customQuantityUnit\":\"PCS\",\"address\":\"广州花都炭步镇岭西路25号厂房\",\"type\":null,\"remark\":null,\"picVersion\":null,\"hasPic\":null,\"specifications\":null,\"brand\":null,\"weight\":null,\"outlineLong\":\"0.0\",\"outlineWidth\":\"0.0\",\"outlineHeight\":\"0.0\",\"accessoryCodeDis\":\"MBGO-1901-015-01-001\",\"figureNo\":\"MBGO-1901-015-01-001\",\"changedFlag\":0,\"applyNumber\":null,\"materialGroup\":\"C0300\",\"materialDescription\":\"检测销_MBGO-1901-015-01-001\",\"processingStatus\":\"N\",\"approvalLabel\":null,\"approvalStatus\":null,\"costCenter\":null,\"settlementIdentifier\":null,\"contactPhone\":null,\"factory\":\"1003\",\"inventoryLocation\":\"5000\",\"memberName\":\"101\",\"contractNo\":\"MBGO-19H1\",\"applicant\":\"10000757\",\"supplier\":null,\"rowNumber\":\"10\",\"purchaseDes\":null,\"applyDate\":null,\"purchasingGroup\":null,\"drawIsChanged\":1,\"custom1\":null,\"custom2\":null,\"custom3\":null,\"custom4\":null,\"custom5\":null,\"custom6\":null,\"custom7\":null,\"custom8\":null,\"custom9\":null,\"custom10\":null}],\"projectName\":null,\"userId\":\"8a2ca9085bec7c0c015c1476c1b1055e\",\"ucenterId\":10312,\"accSource\":null,\"userAccount\":\"企业管理员\",\"bomId\":\"8aaedd0e6860eb1b01686502008908cd\",\"applyType\":null,\"ApplyTypeDescription\":null,\"ApplyNumber\":null,\"bomName\":null,\"applyTypeDescription\":null,\"applyNumber\":null},\"jsonStr\":null,\"order\":null,\"version\":null,\"isNeedPrivate\":null,\"isPurchase\":null,\"entityList\":null,\"fbToken\":null,\"jwtMember\":null}";
        String sign = generatorMd5Header(param, enterpriseConfig.getSecret());
        HttpHeaders headers = new HttpHeaders();
        headers.add("sign", sign);
        headers.add(HttpHeaders.CONTENT_TYPE,"text/plain; charset=utf-8");
        ResponseEntity<HashMap> exchange = restTemplate.exchange("http://192.168.3.61:8089/nonstandard-core/erp/updatePurchaseProject", HttpMethod.PUT, /*携带header*/new HttpEntity<>(param, headers), HashMap.class);
        System.out.println(exchange);
    }


    @PostMapping("hello")
    public EnterpriseConfig hello(@RequestBody Map<String, String> msg) {
        String serialNo = msg.get("serialNo");
        if (serialNo == null) {
            return null;
        }
        return enter.get(serialNo);
    }
    private static String generatorMd5Header(String s, String secret) {
        HmacUtils hmacUtils = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, secret);
        return hmacUtils.hmacHex(s);
    }
    private static class EnterpriseConfig{
        private AuthType authType;
        private String ips;
        /**
         * 混淆字符串
         */
        private String secret;
        /**
         * serialNo
         */
        private String serialNo;

        public String getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(String serialNo) {
            this.serialNo = serialNo;
        }


        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public AuthType getAuthType() {
            return authType;
        }

        public void setAuthType(AuthType authType) {
            this.authType = authType;
        }

        public String getIps() {
            return ips;
        }

        public void setIps(String ips) {
            this.ips = ips;
        }

        @Override
        public String toString() {
            return "EnterpriseConfig{" +
                    "authType=" + authType +
                    ", ips='" + ips + '\'' +
                    ", secret='" + secret + '\'' +
                    ", serialNo='" + serialNo + '\'' +
                    '}';
        }

        public static enum AuthType{
            /**
             * ip限制
             */
            IP,
            /**
             * 不限制
             */
            UNLIMITED,
            /**
             * md5 限制
             */
            MD5,
        }
    }
    private static String getSignData(Map<String, String[]> params) {
        StringBuilder content = new StringBuilder();
        // key 自然排序
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if ("sign".equals(key)) {
                continue;
            }
            String[] strings = params.get(key);
            if (strings != null && strings.length > 1) {
                Arrays.sort(strings);
                for (int j = 0; j < strings.length; j++) {
                    String value = strings[i];
                    if (value != null) {
                        content.append(i == 0 ? "" : "&").append(key).append("=").append(value);
                    } else {
                        content.append(i == 0 ? "" : "&").append(key).append("=");
                    }
                }
            } else {
                if (strings != null && strings[0] != null) {
                    content.append(i == 0 ? "" : "&").append(key).append("=").append(strings[0]);
                } else {
                    content.append(i == 0 ? "" : "&").append(key).append("=");
                }
            }
        }
        return content.toString();
    }

    private static HelloController.EnterpriseConfig randomMap(Map<String, EnterpriseConfig> map) {
        String[] keys = map.keySet().toArray(new String[0]);
        Random random = new Random();
        String key = keys[random.nextInt(keys.length)];
        return map.get(key);
    }

}
