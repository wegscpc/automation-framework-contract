package com.toolshop.dto;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto {
    private String id;  // Changed from Long to String to match API response
    private String name;
    private String slug;
}
