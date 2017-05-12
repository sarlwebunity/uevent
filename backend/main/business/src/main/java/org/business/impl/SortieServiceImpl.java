package org.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.business.ISortieService;
import org.business.logger.ILoggerBusinessService;
import org.business.model.Sortie;
import org.dao.model.SortieEntity;
import org.dao.repository.ISortieRepository;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

/**
 * SortieServiceImpl : Class qui implémente ISortieService
 * 
 */
@Service
public class SortieServiceImpl implements ISortieService {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(ListeCourseServiceImpl.class);

	@Resource
	private Mapper mapper;

	@Resource
	private ILoggerBusinessService loggerService;

	@Resource
	private ISortieRepository sortieRepository;

	@Override
	public Sortie getSortie(Integer id) {
		SortieEntity sortieEntity = sortieRepository.findOne(id);
		Sortie sortie = mapper.map(sortieEntity, Sortie.class);

		return sortie;
	}

	@Override
	public List<Sortie> getSortieByLieu(String lieu) {

		// Récupération de la liste des sortie Entity
		List<SortieEntity> sortiesEntity = sortieRepository.findByLieu(lieu);
		// Inistialisation de la liste des sorties à retourner
		List<Sortie> sorties = new ArrayList<Sortie>();

		// Mapping des sorties Entity en Sortie
		for (SortieEntity sortieEntity : sortiesEntity) {
			Sortie sortie = mapper.map(sortieEntity, Sortie.class);
			sorties.add(sortie);
		}

		return sorties;
	}

	@Override
	public List<Sortie> getAllSortie() {
		
		// Récupération de la liste des sortie Entity
		List<SortieEntity> sortiesEntity = sortieRepository.findAll();
		// Inistialisation de la liste des sorties à retourner
		List<Sortie> sorties = new ArrayList<Sortie>();

		// Mapping des sorties Entity en Sortie
		for (SortieEntity sortieEntity : sortiesEntity) {
			Sortie sortie = mapper.map(sortieEntity, Sortie.class);
			sorties.add(sortie);
		}

		return sorties;
	}

}
