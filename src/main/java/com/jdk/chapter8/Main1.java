package com.jdk.chapter8;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FileName: Main1.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/27 18:49
 */
public class Main1 {
    public static void main(String[] args) {
        //总价 35
        List<VideoOrder> videoOrders1 = Arrays.asList(
                new VideoOrder("20190242812", "springboot教程", 3),
                new VideoOrder("20194350812", "微服务SpringCloud", 5),
                new VideoOrder("20190814232", "Redis教程", 9),
                new VideoOrder("20190523812", "网页开发教程", 9),
                new VideoOrder("201932324", "百万并发实战Netty", 9));
        //总价 54
        List<VideoOrder> videoOrders2 = Arrays.asList(
                new VideoOrder("2019024285312", "springboot教程", 3),
                new VideoOrder("2019081453232", "Redis教程", 9),
                new VideoOrder("20190522338312", "网页开发教程", 9),
                new VideoOrder("2019435230812", "Jmeter压力测试", 5),
                new VideoOrder("2019323542411", "Git+Jenkins持续集成", 7),
                new VideoOrder("2019323542424", "Idea全套教程", 21));


        // 计算交集  // 需要重写equals方法
        System.out.println(videoOrders1.stream().filter(videoOrders2::contains).collect(Collectors.toList()));
        // 计算差集
        System.out.println(videoOrders1.stream().filter(videoOrder -> !videoOrders2.contains(videoOrder)).collect(Collectors.toList()));
        // 并集
        List<VideoOrder> collect1 = videoOrders1.parallelStream().collect(Collectors.toList());
        collect1.addAll(videoOrders2);
        System.out.println(collect1);
        // 去重
        List<VideoOrder> collect = videoOrders1.parallelStream().collect(Collectors.toList());
        collect.addAll(videoOrders2);
        System.out.println(collect.stream().distinct().collect(Collectors.toList()));
        // 平均价格
        System.out.println(collect1.stream().collect(Collectors.averagingInt(value -> value.getMoney())).doubleValue());
        // 总价格
        System.out.println(collect1.stream().collect(Collectors.summarizingInt(VideoOrder::getMoney)).getSum());


    }

    public static class VideoOrder {
        private String tradeNo;
        private int money;
        private String title;

        public VideoOrder(String tradeNo, String title, int money) {
            this.tradeNo = tradeNo;
            this.title = title;
            this.money = money;
        }

        public String getTradeNo() {
            return tradeNo;
        }

        public void setTradeNo(String tradeNo) {
            this.tradeNo = tradeNo;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public int hashCode() {
            return title.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof VideoOrder) {
                VideoOrder o1 = (VideoOrder) obj;
                return title.equals(o1.title);
            }
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "VideoOrder{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}