package sk.fri.uniza.sporthealthsystem.core;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
public class ListingResponse <T>{
    private List<T> data;
    private int currentPage;
    private Long totalItems;
    private int totalPages;
}
