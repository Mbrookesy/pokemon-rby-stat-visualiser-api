# Pokémon RBY Stat Visualizer API

A RESTful API providing detailed information on Pokémon from **Red, Blue, and Yellow** (RBY) versions, including stats, type weaknesses/resistances, movesets, and encounter tables.

## Getting Started

Follow these steps to run the Pokémon RBY Stat Visualizer API locally.

### Prerequisites

Make sure you have the following installed:

- **Java 17** or higher  
- **Gradle** (if you prefer the wrapper, `gradlew` works without installing Gradle)  
- **PostgreSQL** or another supported SQL database  
- **Git** (to clone the repository)

---

### 1. Clone the Repository

```bash
git clone https://github.com/mbrookesy/pokemon-rby-stat-visualiser-api.git
cd pokemon-rby-stat-visualiser-api
```

### 2. Download the Database

1. Obtain the Pokémon RBY database SQL dump from the repository or release assets (e.g. pokemon_rby.sql).
2. Create a new database locally (e.g. pokemon_rby_db):

```bash
psql -U <your_db_username> -c "CREATE DATABASE pokemon_rby_db;"
```
3. import the database dump:

```bash
psql -U <your_db_username> -d pokemon_rby_db -f path/to/pokemon_rby.sql
```

### configure environment variables
Create a .env file in the root of the project with the following content:
```bash
DB_URL=jdbc:postgresql://localhost:5432/pokemon_rby_db
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password
SERVER_PORT=8080
```

### 4. Build the project
```bash
./gradlew clean build
```

### 5. Run the application
```bash
./gradlew bootRun
```



# Endpoints

## Get All Pokémon Names

### GET /pokemon
**Description:**  
Returns a list of all Pokémon with their names and Pokédex numbers.

**Response Example:**
```json
[
  {
    "id": 1,
    "name": "Bulbasaur"
  },
  {
    "id": 2,
    "name": "Ivysaur"
  }
]
```

## Get Pokémon by Dex Number

### GET /pokemon/{id}
**Description:**  
Retrieve full details for a Pokémon, including stats, type weaknesses, and resistances.

**Path Parameters**
`id` - The Pokémon's National Dex number (e.g., 1 for Bulbasaur)

**Response Example:**

```json
{
  "pokemon": {
    "id": 80,
    "name": "Slowbro",
    "type1": "WATER",
    "type2": "PSYCHIC",
    "hp": 95,
    "attack": 75,
    "defense": 110,
    "special": 80,
    "speed": 30,
    "statTotal": 390
  },
  "weaknesses": {
    "weaknesses": [
      "BUG",
      "ELECTRIC",
      "GRASS"
    ],
    "doubleWeaknesses": []
  },
  "resistances": {
    "resistances": [
      "FIGHTING",
      "FIRE",
      "ICE",
      "PSYCHIC",
      "WATER"
    ],
    "doubleResistances": [],
    "immunities": [
      "GHOST"
    ]
  }
}
```

## Get Pokémon Moveset

### GET /moveset/{id}
**Description:**  
Retrieve all moves a Pokémon can learn in Gen 1, including level-up moves and TM/HM moves.

**Path Parameters**
`id` - The Pokémon's National Dex number.

**Response Example:**

```json
{
   "learnset": [
    {
      "moveId": 4,
      "moveName": "Agility",
      "type": "PSYCHIC",
      "category": "Status",
      "power": 0,
      "accuracy": 0,
      "pp": 30,
      "levelLearned": 43,
      "yellowOnly": false
    },
  ],
  "tmMoves": [
    {
      "moveId": 84,
      "moveName": "Mimic",
      "tmName": "TM31",
      "type": "NORMAL",
      "category": "Status",
      "power": 0,
      "accuracy": 100,
      "pp": 10,
      "yellowOnly": false
    },
  ]
}
```

## Get Pokémon Encounter Table

### GET /encounter-table/{id}
**Description:**  
Get all locations and encounter rates for a specific Pokémon in Red, Blue, and Yellow versions.

**Path Parameters**
`id` - The Pokémon's National Dex number.

**Response Example:**

```json
{
  "encounters": [
    {
      "locationName": "Viridian_forest",
      "foundInRed": true,
      "foundInBlue": true,
      "foundInYellow": false,
      "encounterPercentage": 0.05,
      "levelMin": 3,
      "levelMax": 3,
      "area": null,
      "environment": "Walking"
    },
  ]
}

```
