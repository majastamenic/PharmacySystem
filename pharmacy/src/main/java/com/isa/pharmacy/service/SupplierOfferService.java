package com.isa.pharmacy.service;

import com.isa.pharmacy.controller.dto.SupplierOfferDto;
import com.isa.pharmacy.controller.exception.NotFoundException;
import com.isa.pharmacy.controller.exception.UnauthorizeException;
import com.isa.pharmacy.controller.mapping.SupplierOfferMapper;
import com.isa.pharmacy.domain.Order;
import com.isa.pharmacy.domain.SupplierOffer;
import com.isa.pharmacy.domain.enums.OrderOfferType;
import com.isa.pharmacy.repository.SupplierOfferRepository;
import com.isa.pharmacy.service.interfaces.IOrderService;
import com.isa.pharmacy.service.interfaces.ISupplierOfferService;
import com.isa.pharmacy.users.domain.Supplier;
import com.isa.pharmacy.users.service.interfaces.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupplierOfferService implements ISupplierOfferService {

    @Autowired
    private SupplierOfferRepository supplierOfferRepository;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IOrderService orderService;

    public void createOffer(SupplierOffer supplierOffer){
        SupplierOffer dbsupplierOffer = supplierOfferRepository.findSupplierOfferByOrder(supplierOffer.getOrder());
        Order order = orderService.getById(supplierOffer.getOrder().getId());
        if(supplierOffer.getTotalPrice() <= 0 || supplierOffer.getDeliveryDate() == null)
            throw new UnauthorizeException("Enter all fields");
        if(order.getEndDate().before(new Date())){
            throw new UnauthorizeException("You can't change offer for this order.");
        }
        if(dbsupplierOffer != null){
            if(dbsupplierOffer.getType().equals(OrderOfferType.ACCEPTED))
                throw new UnauthorizeException("You can't change or add offer for this order.");
            dbsupplierOffer.setType(supplierOffer.getType());
            dbsupplierOffer.setDeliveryDate(supplierOffer.getDeliveryDate());
            dbsupplierOffer.setTotalPrice(supplierOffer.getTotalPrice());
            supplierOfferRepository.save(dbsupplierOffer);
        }else{
            supplierOfferRepository.save(supplierOffer);
        }
    }

    public List<SupplierOffer> getAllSupplierOffers(String email){
        Supplier supplier = supplierService.getByEmail(email);
        List<SupplierOffer> supplierOfferList = supplierOfferRepository.findSupplierOfferBySupplier(supplier);
        if(supplierOfferList.isEmpty())
            throw new NotFoundException("There is no supplier offer.");
        return supplierOfferList;
    }

    public List<SupplierOffer> filter(String email, OrderOfferType type){
        Supplier supplier = supplierService.getByEmail(email);
        List<SupplierOffer> supplierOfferList = supplierOfferRepository.findSupplierOfferBySupplierAndType(supplier, type);
        if(supplierOfferList.isEmpty())
            throw new NotFoundException("There is no supplier offer");
        if(type == null)
            supplierOfferList = supplierOfferRepository.findSupplierOfferBySupplier(supplier);
        if(supplierOfferList.isEmpty())
            throw new NotFoundException("Supplier "+supplier.getUser().getName()+" "+ supplier.getUser().getSurname()+" doesn't have offer with type " + type);
        return supplierOfferList;
    }

    public SupplierOffer getOffer(Long orderId, String supplierEmail){
        List<SupplierOffer> supplierOfferList = getAllSupplierOffers(supplierEmail);
        for(SupplierOffer supplierOffer: supplierOfferList){
            if(supplierOffer.getOrder().getId().equals(orderId))
                return supplierOffer;
        }
        throw new NotFoundException("Suppler dosen't have offer for order "+orderId);
    }

    public List<SupplierOfferDto> offersByOrderId(Long id){
        List<SupplierOffer> offers = supplierOfferRepository.findAll();
        List<SupplierOfferDto> offersByOrder = new ArrayList<>();
        for(SupplierOffer offer:offers){
            if(offer.getOrder().getId() == id){
                offersByOrder.add(SupplierOfferMapper.mapSupplierOfferToSupplierOfferDto(offer));
            }
        }
        return offersByOrder;
    }

    public SupplierOffer getById(Long id){
        return supplierOfferRepository.getSupplierOfferById(id);
    }

}
