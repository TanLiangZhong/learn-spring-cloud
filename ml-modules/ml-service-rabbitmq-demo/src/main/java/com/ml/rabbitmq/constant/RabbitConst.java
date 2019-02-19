package com.ml.rabbitmq.constant;

/**
 * @author liangzhong
 * @date 2019/1/23 16:37
 */
public interface RabbitConst {

    public final static String ML_MQ = "ML_MQ";

    enum Exchange implements RabbitConst {
        /**
         * 不转发路由(速度最快)
         */
        FANOUT,
        /**
         * 精确转发路由
         */
        DIRECT,
        /**
         * 路由之间模糊匹配转发(速度最慢)
         */
        TOPIC,
        /**
         * 键值对路由(基本很少用到,可以忽略)
         */
        HEADERS;
    }

    enum QueueEnum implements RabbitConst {
        /**
         * 用于测试MQ
         */
        ML_MQ(RabbitConst.ML_MQ, Exchange.DIRECT.name(), RabbitConst.ML_MQ + "_KEY");

        /**
         * 队列
         */
        private String queue;
        /**
         * 交换机
         */
        private String exchange;
        /**
         * 交换路由密钥
         */
        private String routingKey;

        QueueEnum(String queue, String exchange, String routingKey) {
            this.queue = queue;
            this.exchange = exchange;
            this.routingKey = routingKey;
        }

        public String getQueueName() {
            return queue;
        }

        public String getExchangeName() {
            return exchange;
        }

        public String getRoutingKeyName() {
            return routingKey;
        }
    }
}
