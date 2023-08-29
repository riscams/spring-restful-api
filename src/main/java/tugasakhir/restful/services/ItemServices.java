package tugasakhir.restful.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tugasakhir.restful.entities.Item;
import tugasakhir.restful.handler.request.ItemDto;
import tugasakhir.restful.handler.response.ItemAllResponse;
import tugasakhir.restful.handler.response.ItemResponse;
import tugasakhir.restful.repository.ItemRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class ItemServices {

    @Autowired
    private ItemRepo itemRepo;

    public List<ItemAllResponse> getAllItems() {
        List<Item> items = itemRepo.findAll();

        List<ItemAllResponse> responses = new ArrayList<>();

        for (Item item : items){
            ItemAllResponse response = new ItemAllResponse();
            response.setItemId(item.getItemId());
            response.setItemCode(item.getItemCode());
            response.setItemName(item.getItemName());
            response.setItemQty(item.getItemQty());
            responses.add(response);
        }
        return responses;
    }

    @Transactional
    public String createItem(ItemDto itemDto) {
        Item item = new Item();
        item.setItemCode(itemDto.getItemCode());
        item.setItemName(itemDto.getItemName());
        item.setItemQty(itemDto.getItemQty());
        item.setCreatedDate(new Date());

        itemRepo.save(item);

        return "Successfully created new item!";
    }

    @Transactional
    public String updateItem(ItemDto itemDto, int itemId)
            throws Exception {
        Optional<Item> item = itemRepo.findById(itemId);

        if (!item.isPresent()) {
            throw new Exception("Item with ID " + itemId + " not found");
        }

        item.get().setItemQty(itemDto.getItemQty());
        item.get().setUpdatedDate(new Date());

        itemRepo.save(item.get());

        return "Successfully updated an item!";
    }

    @Transactional
    public String deleteItem(int itemId)
            throws Exception {
        Optional<Item> item = itemRepo.findById(itemId);

        if (!item.isPresent()) {
            throw new Exception("Item with ID " + itemId + " not found");
        }

        itemRepo.delete(item.get());

        return "Successfully deleted an item!";
    }


}
