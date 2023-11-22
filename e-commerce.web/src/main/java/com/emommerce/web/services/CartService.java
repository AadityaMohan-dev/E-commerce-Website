package com.emommerce.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emommerce.web.repo.CartRepo;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepository;

    public ResponseEntity<Object> delCartElementById(Long id) {
        return null;
    }

}
// dekh abi kya scene h sabhi customer sey one to one relation ship h cart ka or
// cart ka 1-m relation product sey
// ya toh tu frontend sey cart bana or jo bhi ho usko backend ko send kr ismey
// ek dikat h cart dynamic hoti h toh hr change p server hit krna hoga jo good
// practice ni h .
// toh apun kuch session manager kuch bandeygey jo frontend p toh time p show
// kreyga changes
// but backend p kuch interval m chejey update hogi iska bhi drawback h vo ye h
// ki user change krkey site he bnd krdey toh update ni ho paeyga
// iskey liyekuch asa krna padeyga ki jo changes made ho rahey h vo temporary
// kahi save hotey rahey or baad m jakey server p update hojaey. 
//option-1 cookies msave kradey data .
//option-2 local storage m .
//option - 3 net p dekh  cause tuney kahi toh padha h ye case . . .