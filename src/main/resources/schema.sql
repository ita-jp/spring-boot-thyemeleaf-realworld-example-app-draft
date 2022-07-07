CREATE TABLE IF NOT EXISTS articles (
  id UUID PRIMARY KEY,
  author_id UUID NOT NULL,
  title text NOT NULL,
  description text NOT NULL,
  body text NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT current_timestamp,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT current_timestamp
);
