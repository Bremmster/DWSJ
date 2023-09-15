Test 1
Pokemon
{
    pokeId=8,
    name='pika',
    pokemonPokemonTypes=[Type{slot=1, pokemonType='grass'}, Type{slot=2, pokemonType='poison'}],
    total=210,
    hp=100,
    attack=50,2
    defence=60
}
Test 2
{
    pokeId:9,
    name:pika,   <- saknar fnuttar
    total:210,
    hp:100,
    attack:50,
    defence:60,
    pokemonPokemonTypes:[Type{slot=1, pokemonType='grass'}, Type{slot=2, pokemonType='poison'}]}

Test 3
{
    pokeId:10,
    name:"pika",
    total:210,
    hp:100,
    attack:50,
    defence:60,
    pokemonPokemonTypes: [
        {slot:"1",
        pokemonType:"grass"
        },
        {
        slot:"2",
        pokemonType:"poison"
        }
    ]
}

test 4
{
  "pokeId:"12,
	"name:""pika",
    "total:"210,
    "hp:"100,
    "attack:"50,
    "defence:"60,
    "pokemonPokemonTypes:" [
        {
        "slot:""1",
        "pokemonType:""grass"
        },
        {
        "slot:""2",
        "pokemonType:""poison"
        }
    ]
}

Proper Json
{
    "pokeId": 8,
    "name": "pika",
    "total": 210,
    "hp": 100,
    "attack": "50",
    "defence": "60",
    "pokemonPokemonTypes": [
        {
            "slot": 1,
            "pokemonType": "grass"
        },
        {
            "slot": 2,
            "pokemonType": "poison"
        }
    ]
}
