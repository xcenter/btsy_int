CREATE table IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE table IF NOT EXISTS jackpots (
    id INT PRIMARY KEY AUTO_INCREMENT,
    pool DOUBLE NOT NULL,
    contribution_function_name VARCHAR(255) NOT NULL,
    win_function_name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    min_pool DOUBLE NOT NULL,
    max_pool DOUBLE NOT NULL
);

CREATE table IF NOT EXISTS bets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    jackpot_id INT NOT NULL,
    bet_amount DOUBLE NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(jackpot_id) REFERENCES jackpots(id)
);

CREATE table IF NOT EXISTS jackpot_wins (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    jackpot_id INT NOT NULL,
    bet_id INT NOT NULL,
    win_amount DOUBLE NOT NULL,
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

INSERT INTO jackpots (id, pool, contribution_function_name, win_function_name, created_at, min_pool, max_pool) VALUES
(1, 1000, 'FixedContribution', 'FixedWinChance', CURRENT_TIMESTAMP, 500, 2000),
(2, 2000, 'LinearContribution', 'LinearWinChance', CURRENT_TIMESTAMP, 1000, 20000),
(3, 3000, 'FixedContribution', 'LinearWinChance', CURRENT_TIMESTAMP, 1500, 50000),
(4, 4000, 'LinearContribution', 'FixedWinChance', CURRENT_TIMESTAMP, 2000, 1000000),
(5, 5000, 'FixedContribution', 'FixedWinChance', CURRENT_TIMESTAMP, 2500, 5000000);