package com.sxx.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.sxx.elasticsearch.config.ElasticsearchConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TechSearchApplicationTests {

    @Resource
    private RestHighLevelClient client;

    @Test
    void searchData() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        //指定索引
        searchRequest.indices("bank");
        //构造查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("gender", "F");
        builder.query(queryBuilder);
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAvg").field("age").size(10);
        AvgAggregationBuilder balanceAgg = AggregationBuilders.avg("balance").field("balance");
        builder.aggregation(ageAgg).aggregation(balanceAgg);
        searchRequest.source(builder);
        //执行检索
        SearchResponse search = client.search(searchRequest, ElasticsearchConfig.COMMON_OPTIONS);
        SearchHits hits = search.getHits();
        SearchHit[] searchHits = hits.getHits();
        ArrayList<Account> accounts = new ArrayList<>();
        for (SearchHit searchHit : searchHits) {
            String sourceAsString = searchHit.getSourceAsString();
            Account account = JSON.parseObject(sourceAsString, Account.class);
            accounts.add(account);
        }
        for (Account account : accounts) {
            System.out.println(account);
        }

        //获取聚合分析信息
        Aggregations aggregations = search.getAggregations();
        Terms ageRes = aggregations.get("ageAvg");
        for (Terms.Bucket bucket : ageRes.getBuckets()) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println("年龄：" + keyAsString);
        }
        Avg balance= aggregations.get("balance");
        System.out.println("平均值"+balance.getValue());

    }

    @Test
    void contextLoads() {
        System.out.println(client);
    }

    @Test
    void indexDate() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");
        Map<String, String> map = new HashMap<>();
//        map.put("name", "张三");
//        map.put("age", "18");
//        indexRequest.source(map, XContentType.JSON);
        User user = new User("沈贤鑫", 22);
        String json = JSON.toJSONString(user);
        indexRequest.source(json, XContentType.JSON);
        IndexResponse index = client.index(indexRequest, ElasticsearchConfig.COMMON_OPTIONS);
        String str = index.getIndex();
    }

    @Data
    @AllArgsConstructor
    static class User {
        private String name;

        private Integer age;
    }

    @ToString
    @Data
    static class Account {
        private int account_number;
        private int balance;
        private String firstname;
        private String lastname;
        private int age;
        private String gender;
        private String address;
        private String employer;
        private String email;
        private String city;
        private String state;
    }

}
