package tugasakhir.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tugasakhir.restful.entities.Item;
import tugasakhir.restful.handler.request.ItemDto;
import tugasakhir.restful.handler.response.ItemAllResponse;
import tugasakhir.restful.handler.response.ItemResponse;
import tugasakhir.restful.services.ItemServices;

import java.util.List;

@RestController
@RequestMapping("api-v1/item")
public class ItemController {
    @Autowired
    private ItemServices itemServices;

    @GetMapping("all")
    public ResponseEntity getItems() {
        List<ItemAllResponse> items = itemServices.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping("create")
    public ResponseEntity createItem(@RequestBody ItemDto itemDto) {
        String result = itemServices.createItem(itemDto);
        ItemResponse response = new ItemResponse();
        response.setStatus("Created");
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setResultMessage(result);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PostMapping("updateQty")
    public ResponseEntity updateItem(@RequestBody ItemDto itemDto, @RequestParam("itemId") int itemId) {
        try {
            String response = itemServices.updateItem(itemDto, itemId);
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("deleteItem")
    public ResponseEntity deleteItem(@RequestParam("itemId") int itemId) {
        try {
            String response = itemServices.deleteItem(itemId);
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
