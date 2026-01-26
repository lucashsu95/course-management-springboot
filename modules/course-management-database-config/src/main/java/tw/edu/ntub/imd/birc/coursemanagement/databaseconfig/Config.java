package tw.edu.ntub.imd.birc.coursemanagement.databaseconfig;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration("databaseConfig")
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.dao")
@EnableTransactionManagement
@EntityScan(basePackages = "tw.edu.ntub.imd.birc.coursemanagement.databaseconfig.entity")
public class Config {
    public static final String DATABASE_NAME = "course_management";

    @Bean
    public TransactionInterceptor transactionInterceptor(TransactionManager transactionManager) {
        NameMatchTransactionAttributeSource attributeSource = new NameMatchTransactionAttributeSource();
        RuleBasedTransactionAttribute requiredAttribute = new RuleBasedTransactionAttribute();
        RollbackRuleAttribute rollbackRuleAttribute = new RollbackRuleAttribute(RuntimeException.class);
        requiredAttribute.setRollbackRules(Collections.singletonList(rollbackRuleAttribute));
        requiredAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        DefaultTransactionAttribute readOnlyTransactionAttributes = new DefaultTransactionAttribute(
                TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
        readOnlyTransactionAttributes.setReadOnly(true);
        Map<String, TransactionAttribute> namedMap = new HashMap<>();
        namedMap.put("add*", requiredAttribute);
        namedMap.put("save*", requiredAttribute);
        namedMap.put("create*", requiredAttribute);
        namedMap.put("update*", requiredAttribute);
        namedMap.put("logout", requiredAttribute);
        namedMap.put("delete*", requiredAttribute);
        namedMap.put("find*", readOnlyTransactionAttributes);
        namedMap.put("get*", readOnlyTransactionAttributes);
        namedMap.put("search*", readOnlyTransactionAttributes);
        namedMap.put("getCount*", readOnlyTransactionAttributes);
        namedMap.put("*", readOnlyTransactionAttributes);
        attributeSource.setNameMap(namedMap);
        return new TransactionInterceptor(transactionManager, attributeSource);
    }
}
