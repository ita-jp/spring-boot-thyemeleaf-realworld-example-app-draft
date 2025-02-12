CREATE TABLE IF NOT EXISTS users (
  id UUID PRIMARY KEY,
  username text NOT NULL UNIQUE,
  email VARCHAR(256) NOT NULL UNIQUE,
  password VARCHAR(256) NOT NULL,
  image_url text,
  bio text,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT current_timestamp,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS articles (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL references users(id),
  title text NOT NULL,
  description text NOT NULL,
  body text NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT current_timestamp,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT current_timestamp
);
