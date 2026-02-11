# Pokémon RBY Stat Visualizer API

A RESTful API providing detailed information on Pokémon from **Red, Blue, and Yellow** (RBY) versions, including stats, type weaknesses/resistances, movesets, and encounter tables.

---

## Table of Contents

- [Endpoints](#endpoints)  
  - [Get All Pokémon Names](#get-all-pokémon-names)  
  - [Get Pokémon by Dex Number](#get-pokémon-by-dex-number)  
  - [Get Pokémon Moveset](#get-pokémon-moveset)  
  - [Get Pokémon Encounter Table](#get-pokémon-encounter-table)  
- [Response Formats](#response-formats)  
- [Error Handling](#error-handling)  
- [Technologies](#technologies)  

---

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
