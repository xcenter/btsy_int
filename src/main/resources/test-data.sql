INSERT INTO users (name) VALUES
('Alice'),
('Bob'),
('Charlie'),
('David'),
('Eve');

INSERT INTO contribution_config (contribution_type, variable_rate_function) VALUES
('fixed', NULL, 50),
('variable', 'GrowingContributionRateFunction', NULL);

INSERT INTO win_chance_config (win_chance, variable_rate_function, fixed_rate) VALUES
('fixed', NULL, 10),
('variable', 'GrowingWinChanceRateFunction', NULL);

INSERT INTO jackpots (pool, contribution_config_id, win_config_id) VALUES
(1000, 1, 1),
(2000, 2, 2),
(3000, 1, 2),
(4000, 2, 1),
(5000, 1, 1);