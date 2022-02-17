package com.example.sentinel.basic;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liugang
 * @create 2022/2/15
 */
public class BasicDemo {

    public static void main(String[] args) throws Exception {
        initFlowRules();
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("HelloWorld");
                // 业务执行开始
                System.out.println("hello world");
                // 业务执行结束
            } catch (FlowException ex) {
                System.out.println("block");
                Thread.sleep(1000 * 60);
            } catch (Exception ex) {
                System.out.println("unknow exception");
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }
    }

    /**
     * 规则初始化
     */
    private static void initFlowRules() {
        List<FlowRule> ruleList = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // set limit qps to 20
        rule.setCount(20);
        ruleList.add(rule);
        FlowRuleManager.loadRules(ruleList);
    }

}
