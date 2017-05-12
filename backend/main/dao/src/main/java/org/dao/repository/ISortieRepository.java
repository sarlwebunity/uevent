package org.dao.repository;

import java.util.List;

import org.dao.model.SortieEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Accès aux données Sorties.
 *
 * @author freboul
 */
public interface ISortieRepository extends PagingAndSortingRepository<SortieEntity, Integer> {
	
	/**
     * Methode qui retoure la table complete sorties
     *
     * @return une liste de sortieEntity
     */
    List<SortieEntity> findAll();
    
    /**
     * Methode qui retoure une liste de sorties en fonction du lieu
     *
     * @return une liste de sortieEntity
     */
    List<SortieEntity> findByLieu(String lieu);    
}
