create table OAuthApplication (
	applicationId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ownerId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	website VARCHAR(75) null,
	consumerKey VARCHAR(75) null,
	consumerSecret VARCHAR(75) null,
	callBackURL VARCHAR(75) null,
	accessLevel INTEGER
);

create table OAuthApplications_Users (
	oaauid LONG not null primary key,
	accessToken VARCHAR(75) null,
	accessSecret VARCHAR(75) null,
	applicationId LONG,
	authorized BOOLEAN,
	userId LONG
);

create table OAuth_Application (
	applicationId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	website VARCHAR(75) null,
	callBackURL VARCHAR(75) null,
	accessLevel INTEGER,
	consumerKey VARCHAR(75) null,
	consumerSecret VARCHAR(75) null
);

create table OAuth_ApplicationUser (
	oaauId LONG not null primary key,
	userId LONG,
	applicationId LONG,
	accessToken VARCHAR(75) null,
	accessSecret VARCHAR(75) null,
	authorized BOOLEAN
);