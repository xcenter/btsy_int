CREATE table IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
);

CREATE table IF NOT EXISTS jackpots (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pool BIGINT(100) NOT NULL,
    contribution_config_id INT NOT NULL,
    win_config_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    FOREIGN KEY(contribution_config_id) REFERENCES contribution_config(id),
    FOREIGN KEY(win_config_id) REFERENCES win_chance_config(id)
);

CREATE table IF NOT EXISTS contribution_config (
    id INT PRIMARY KEY AUTO_INCREMENT,
    contribution_type ENUM('fixed', 'variable') NOT NULL,
    variable_rate_function VARCHAR(255),
    fixed_rate INT(100)
);

CREATE table IF NOT EXISTS win_chance_config (
    id INT PRIMARY KEY AUTO_INCREMENT,
    win_chance ENUM('variable', 'fixed') NOT NULL,
    variable_rate_function VARCHAR(255)
    fixed_rate INT(100)
);

CREATE table IF NOT EXISTS bets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    jackpot_id INT NOT NULL,
    bet_amount INT(100) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(jackpot_id) REFERENCES jackpots(id)
);

CREATE table IF NOT EXISTS jackpot_wins (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    jackpot_id INT NOT NULL,
    bet_id INT NOT NULL,
    win_amount INT(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(jackpot_id) REFERENCES jackpots(id)
    FOREIGN KEY(bet_id) REFERENCES bets(id)
);