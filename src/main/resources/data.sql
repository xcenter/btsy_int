CREATE table IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE table IF NOT EXISTS jackpots (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pool INT NOT NULL,
    contribution_config_id INT NOT NULL,
    win_config_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    min_pool INT NOT NULL,
    max_pool INT NOT NULL,
    FOREIGN KEY(contribution_config_id) REFERENCES contribution_config(id),
    FOREIGN KEY(win_config_id) REFERENCES win_chance_config(id)
);

CREATE table IF NOT EXISTS contribution_config (
    id INT PRIMARY KEY AUTO_INCREMENT,
    function_name ENUM ('Fixed', 'GrowingContributionRateFunction') NOT NULL,
    fixed_rate INT
);

CREATE table IF NOT EXISTS win_chance_config (
    id INT PRIMARY KEY AUTO_INCREMENT,
    function_name ENUM ('Fixed', 'GrowingWinChanceRateFunction') NOT NULL,
    fixed_rate INT
);

CREATE table IF NOT EXISTS bets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    jackpot_id INT NOT NULL,
    bet_amount INT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(jackpot_id) REFERENCES jackpots(id)
);

CREATE table IF NOT EXISTS jackpot_wins (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    jackpot_id INT NOT NULL,
    bet_id INT NOT NULL,
    win_amount INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(jackpot_id) REFERENCES jackpots(id),
    FOREIGN KEY(bet_id) REFERENCES bets(id)
);

INSERT INTO users (id,name) VALUES
(1,'Alice'),
(2,'Bob'),
(3,'Charlie'),
(4,'David'),
(5,'Eve');

INSERT INTO contribution_config (function_name, fixed_rate) VALUES
('Fixed', 50),
('GrowingContributionRateFunction', NULL);

INSERT INTO win_chance_config (function_name, fixed_rate) VALUES
('Fixed', 10),
('GrowingWinChanceRateFunction', NULL);

INSERT INTO jackpots (id, pool, contribution_config_id, win_config_id, created_at, min_pool, max_pool) VALUES
(1, 1000, 1, 1, CURRENT_TIMESTAMP, 500, 2000),
(2, 2000, 2, 2, CURRENT_TIMESTAMP, 1000, 20000),
(3, 3000, 1, 2, CURRENT_TIMESTAMP, 1500, 50000),
(4, 4000, 2, 1, CURRENT_TIMESTAMP, 2000, 1000000),
(5, 5000, 1, 1, CURRENT_TIMESTAMP, 2500, 5000000);