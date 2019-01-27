package com.ml.java8;

import com.ml.bean.anime.entity.Anime;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * java8 - Stream 简单Demo
 *
 * @author liangzhong
 * @version 1.0
 * @date 2019/1/27
 */
public class SimpleDemo {

    public static void test1() {
        System.out.println("\n-----------------------------ForEach-------------------------------\n");
        List<Anime> animeList = Anime.getParam();
        // forEach 方法来迭代流中的每个数据
        animeList.forEach(System.out::println);

        System.out.println(" \n-----------------------------Map-------------------------------\n");
        // map 方法用于映射每个元素到对应的结果
        String descriptions = animeList.stream().map(Anime::getDescription).collect(Collectors.joining(","));
        List<String> descriptionList = animeList.stream().map(Anime::getDescription).collect(Collectors.toList());
        System.out.println("descriptions = " + descriptions);
        System.out.println("descriptionList = " + descriptionList);

        System.out.println("\n-----------------------------Filter-------------------------------\n");
        // filter 方法用于通过设置的条件过滤出元素
        List<Anime> list1 = new ArrayList<>();
        list1.add(new Anime("佩恩", "和平"));
        list1.add(new Anime("迪达拉", "艺术"));
        list1.forEach(a -> System.out.println("Filter " + animeList.stream().filter(anime -> anime.getName().equals(a.getName())).findFirst().toString()));

        System.out.println("\n-----------------------------Limit-------------------------------\n");
        // limit 方法用于获取指定数量的流
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        System.out.println("\n-----------------------------Parallel-------------------------------\n");
        // 并行（parallel）程序
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("count = " + count);

        System.out.println("\n-----------------------------GroupingBy-------------------------------\n");
        // 分组 对流进行分组
        Map<String, List<Anime>> groupAnime = animeList.stream().collect(Collectors.groupingBy(Anime::getName));
        System.out.println("GroupAnime = " + groupAnime);

        System.out.println("\n-----------------------------ToMap-------------------------------\n");
        // toMap list 转换 Map
        Map<String, Anime> animeMap = animeList.stream().collect(Collectors.toMap(Anime::getName, Function.identity() , (k1,k2) -> k2));
        System.out.println("AnimeMap = " + animeMap);

        System.out.println("\n-----------------------------统计-------------------------------\n");
        //一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    public static void main(String[] args) {
        SimpleDemo.test1();
    }

}
