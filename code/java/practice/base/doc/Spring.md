# Bean初始化接口
```
public interface InitializingBean {
   
   	/**
   	 * Invoked by the containing {@code BeanFactory} after it has set all bean properties
   	 * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
   	 * <p>This method allows the bean instance to perform validation of its overall
   	 * configuration and final initialization when all bean properties have been set.
   	 * @throws Exception in the event of misconfiguration (such as failure to set an
   	 * essential property) or if initialization fails for any other reason
   	 */
   	void afterPropertiesSet() throws Exception;
   
   }

D:\Program Files\apache-maven-3.6.3\repository\org\springframework\data\spring-data-redis\2.1.10.RELEASE\spring-data-redis-2.1.10.RELEASE-sources.jar!\org\springframework\data\redis\core\RedisTemplate.java

@Override
	public void afterPropertiesSet() {

		super.afterPropertiesSet();

		boolean defaultUsed = false;

		if (defaultSerializer == null) {

			defaultSerializer = new JdkSerializationRedisSerializer(
					classLoader != null ? classLoader : this.getClass().getClassLoader());
		}

		if (enableDefaultSerializer) {

			if (keySerializer == null) {
				keySerializer = defaultSerializer;
				defaultUsed = true;
			}
			if (valueSerializer == null) {
				valueSerializer = defaultSerializer;
				defaultUsed = true;
			}
			if (hashKeySerializer == null) {
				hashKeySerializer = defaultSerializer;
				defaultUsed = true;
			}
			if (hashValueSerializer == null) {
				hashValueSerializer = defaultSerializer;
				defaultUsed = true;
			}
		}

		if (enableDefaultSerializer && defaultUsed) {
			Assert.notNull(defaultSerializer, "default serializer null and not all serializers initialized");
		}

		if (scriptExecutor == null) {
			this.scriptExecutor = new DefaultScriptExecutor<>(this);
		}

		initialized = true;
	}

```