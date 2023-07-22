package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) { //상품 저장
        itemRepository.save(item);
    }

    //변경 감지 기능 적용 영속성으로 관리되어 셋팅된 값만 DB에서 업데이트한다.
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = itemRepository.findOne(itemId);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems() { //상품 조회
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) { //상품 목록 조회
        return itemRepository.findOne(itemId);
    }

}

