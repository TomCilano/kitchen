INSERT INTO public.iron_user (id, display_name, password, username) VALUES (1, 'Jason Skipper', 'password', 'jason');

INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (1, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (2, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 1');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (3, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 2');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (4, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 3');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (5, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 4');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (6, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 5');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (7, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 6');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (8, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 7');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (9, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 8');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (10, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 9');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (11, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 10');
INSERT INTO public.movie (id, description, minutes, rating, remote_url, title) VALUES (12, 'Cool Sci Fi', 123, 'R', 'https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg', 'The Matrix 11');

INSERT INTO public.permission (id, description, key) VALUES (1, 'Add Users', 'ADMIN_ADD_USER');
INSERT INTO public.permission (id, description, key) VALUES (2, 'View R-rated', 'USER_VIEW_R');

INSERT INTO public.iron_user_favs (iron_user_id, favs_id) VALUES (1, 2);
INSERT INTO public.iron_user_favs (iron_user_id, favs_id) VALUES (1, 5);

INSERT INTO public.iron_user_abilities (iron_user_id, abilities_id) VALUES (1, 1);
