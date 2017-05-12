package org.business.impl;

import javax.annotation.Resource;

import org.business.IUserService;
import org.business.logger.ILoggerBusinessService;
import org.business.model.User;
import org.dao.model.UserEntity;
import org.dao.repository.IUserRepository;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl : Class qui implémente IUserService retourn un
 * 
 */
@Service
public class UserServiceImpl implements IUserService {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(ListeCourseServiceImpl.class);

	@Resource
	private Mapper mapper;

	@Resource
	private ILoggerBusinessService loggerService;

	@Resource
	private IUserRepository userRepository;

	@Override
	public User getUser(Integer id) {

		// Récupération du user par rapport à l'id
		UserEntity userEntity = userRepository.findOne(id);
		// Mapping du user entity en user
		User user = mapper.map(userEntity, User.class);

		return user;
	}

	@Override
	public Boolean isAuthorized(User user, String codeIdent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		
		//Conversion du user en userEntity
		UserEntity userEntity = mapper.map(user, UserEntity.class);
		
		//Création du user en base de donnée
		UserEntity userEntityCreate = userRepository.save(userEntity);
		
		//Mapping du userEntity en user
		User userCreate = mapper.map(userEntityCreate, User.class);
		
		return userCreate;
	}

}
