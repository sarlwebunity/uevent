package org.dao.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration Spring pour la couche d'accès aux données (DAO).
 *
 * @author freboul
 */
@Configuration
@EntityScan(basePackages = "org.dao.model")
@EnableJpaRepositories(basePackages = "org.dao.repository")
public class SpringDaoConfig {

}
