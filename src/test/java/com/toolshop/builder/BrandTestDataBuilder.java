package com.toolshop.builder;

import com.toolshop.dto.BrandDto;

/**
 * Builder pattern implementation for creating test data.
 * Makes test data creation more maintainable and readable.
 */
public class BrandTestDataBuilder {
    private String id = "01JHTKACQV2ENDEGXJ4XQGWNVM";
    private String name = "ForgeFlex Tools";
    private String slug = "forgeflex-tools";
    
    public static BrandTestDataBuilder aDefaultBrand() {
        return new BrandTestDataBuilder();
    }
    
    public BrandTestDataBuilder withId(String id) {
        this.id = id;
        return this;
    }
    
    public BrandTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }
    
    public BrandTestDataBuilder withSlug(String slug) {
        this.slug = slug;
        return this;
    }
    
    public BrandDto build() {
        return BrandDto.builder()
                .id(id)
                .name(name)
                .slug(slug)
                .build();
    }
    
    public String toJsonString() {
        return String.format(
            "{\"id\": \"%s\", \"name\": \"%s\", \"slug\": \"%s\"}",
            id, name, slug
        );
    }
}
