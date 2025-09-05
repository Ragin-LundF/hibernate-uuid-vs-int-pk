package io.finapi.dbinsert.config

import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder
import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation
import org.springframework.aop.framework.ProxyFactory
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import org.springframework.util.ReflectionUtils
import javax.sql.DataSource

@Configuration
@ConditionalOnProperty("dbinsert.log.batch.enabled", havingValue = "true", matchIfMissing = false)
class DatasourceProxyBeanPostProcessor : BeanPostProcessor {

    @Throws(BeansException::class)
    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any {
        return bean
    }

    @Throws(BeansException::class)
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any {
        if (bean is DataSource) {
            val factory = ProxyFactory(bean)
            factory.isProxyTargetClass = true
            factory.addAdvice(ProxyDataSourceInterceptor(bean))
            return factory.proxy
        }
        return bean
    }

    private class ProxyDataSourceInterceptor(dataSource: DataSource?) : MethodInterceptor {
        private val dataSource: DataSource = ProxyDataSourceBuilder
            .create(dataSource)
            .countQuery()
            .logQueryBySlf4j(SLF4JLogLevel.INFO)
            .build()

        @Suppress("SpreadOperator")
        @Throws(Throwable::class)
        override fun invoke(invocation: MethodInvocation): Any? {
            val proxyMethod = ReflectionUtils.findMethod(dataSource.javaClass, invocation.method.name)
            if (proxyMethod != null) {
                return proxyMethod.invoke(dataSource, *invocation.arguments)
            }
            return invocation.proceed()
        }
    }
}
