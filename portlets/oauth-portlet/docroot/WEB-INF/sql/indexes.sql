create index IX_3E994709 on OAuthApplication (companyId);
create unique index IX_BF52271A on OAuthApplication (consumerKey);
create index IX_834AE8F9 on OAuthApplication (userId);

create index IX_FEDEB9BB on OAuthApplicationUser (accessToken);
create index IX_AD89EED1 on OAuthApplicationUser (applicationId);
create index IX_E5FAEAA0 on OAuthApplicationUser (applicationId, authorized);
create index IX_DEC47AA4 on OAuthApplicationUser (userId);
create unique index IX_23292557 on OAuthApplicationUser (userId, applicationId);
create index IX_CABB51F3 on OAuthApplicationUser (userId, authorized);