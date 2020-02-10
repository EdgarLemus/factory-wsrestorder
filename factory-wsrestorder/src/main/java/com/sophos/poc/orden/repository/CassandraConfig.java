package com.sophos.poc.orden.repository;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories("com.sophos.poc.orden.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {
	
	private static final String USERNAME = System.getenv("POC_CASSANDRA_USERNAME");
	private static final String PASSWORD = System.getenv("POC_CASSANDRA_PASSWORD");
	private static final String KEYSPACE_NAME = System.getenv("POC_CASSANDRA_KEYSPACE");
	private static final String CONTACT_POINTS = System.getenv("POC_CASSANDRA_HOST");
	private static final int PORT = Integer.parseInt(System.getenv("POC_CASSANDRA_PORT"));

	@Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setUsername(USERNAME);
        cluster.setPassword(PASSWORD);
        cluster.setContactPoints(CONTACT_POINTS);
        cluster.setPort(PORT);
        return cluster;
    }
	
    @Bean
    public CassandraMappingContext mappingContext()  throws ClassNotFoundException {
	   CassandraMappingContext mappingContext= new CassandraMappingContext();
	   mappingContext.setInitialEntitySet(getInitialEntitySet());
    	    return mappingContext;
    }
    
    @Override
    protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
        return CassandraEntityClassScanner.scan(getEntityBasePackages());
    }
    
	@Override
	protected String getKeyspaceName() {
		return KEYSPACE_NAME;
	}

}