package org.hillel.controller.tl;

import lombok.RequiredArgsConstructor;
import org.hillel.controller.convertor.VehicleMapper;
import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.service.jpa.TicketClientJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class VehicleTlController {

    private final TicketClientJpa ticketClientJpa;
    private final VehicleMapper vehicleMapper;

    @GetMapping("/vehicles")
    public ModelAndView homeVehiclePage(Model model){
        final Collection<VehicleEntity> allVehicles = ticketClientJpa.findAllVehicles();
        model.addAttribute("vehicles", allVehicles.stream().map(vehicleMapper::vehicleToVehicleDto).collect(Collectors.toList()));
        return new ModelAndView("vehicles_view");
    }
    // /vehicle/delete?id=1&name=test
//    @GetMapping("/vehicle/delete/{vehicleId}")
//    public String deleteVehicle(@RequestParam("id") Long vehicleId,
//                                @RequestParam(value = "name", required = false) String vehicleName){
//
//    }

    @GetMapping("/vehicle/delete/{vehicleId}")
    public RedirectView deleteVehicle(@PathVariable("vehicleId") Long vehicleId){
        ticketClientJpa.removeVehicleById(vehicleId);
        return new RedirectView("/tl/vehicles");
    }

    @PostMapping("/vehicle/save")
    public RedirectView save(@ModelAttribute("vehSave") VehicleDto vehicleDto){
        final VehicleEntity vehicle = vehicleMapper.vehicleDtoToVehicle(vehicleDto);
        ticketClientJpa.createOrUpdateVehicle(vehicle);
        return new RedirectView("/tl/vehicles");
    }
}
