package org.dao.repository;

import java.util.List;

import org.dao.model.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Accès aux données Produit.
 *
 * @author freboul
 */
public interface IUserRepository extends PagingAndSortingRepository<UserEntity, Integer> {
	
	/**
     * Methode qui retoure la table complete utilisateurs
     *
     * @return une liste de userEntity
     */
    List<UserEntity> findAll();
    
    
}
