db.createUser(
	{
		user: 'user',
		pwd: 'password',
		roles: [{role: 'readWrite', db: 'miniautorizador'}]
	}
);

db.createCollection('usuario');

db.usuario.insertMany([
	{
		name: 'Admin',
		email: 'desafio@email.com',
		password: '$2a$10$.Umr3yZVoO6qU7mHrsiBMeQIAJ1LvT9g1TTenEKpLSwJQrftmP1FK',
		profile: 'ROLE_ADM',
		active: true,
		createdDate: new Date()
	}
]);