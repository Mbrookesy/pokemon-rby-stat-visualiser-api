package org.mbrookesy.pokemon.visualiser.entities.Pokemon;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
@SuppressWarnings("unused")
public class TypeConverter implements AttributeConverter<PokemonType, String> {

    @Override
    public String convertToDatabaseColumn(PokemonType type) {
        return type == null ? null : type.name().toLowerCase();
    }

    @Override
    public PokemonType convertToEntityAttribute(String dbValue) {
        if (dbValue == null) return null;
        return PokemonType.valueOf(dbValue.toUpperCase());
    }
}
