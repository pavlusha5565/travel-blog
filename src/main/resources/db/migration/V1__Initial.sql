CREATE TABLE roles (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE "user" (
  id VARCHAR(255) NOT NULL,
   username VARCHAR(100) NOT NULL,
   email VARCHAR(100) NOT NULL,
   password VARCHAR(100) NOT NULL,
   is_account_non_expired BOOLEAN NOT NULL,
   is_account_non_locked BOOLEAN NOT NULL,
   is_credentials_non_expired BOOLEAN NOT NULL,
   is_enabled BOOLEAN NOT NULL,
   created_at TIMESTAMP WITHOUT TIME ZONE,
   updated_at TIMESTAMP WITHOUT TIME ZONE,
   CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_roles (
  user_entity_id VARCHAR(255) NOT NULL,
   roles_id BIGINT NOT NULL,
   CONSTRAINT pk_user_roles PRIMARY KEY (user_entity_id, roles_id)
);

ALTER TABLE "user" ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE "user" ADD CONSTRAINT uc_user_username UNIQUE (username);

ALTER TABLE user_roles ADD CONSTRAINT fk_userol_on_role_entity FOREIGN KEY (roles_id) REFERENCES roles (id);

ALTER TABLE user_roles ADD CONSTRAINT fk_userol_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES "user" (id);