package sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.entity.PlayerAddress;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.service.PlayerAddressService;

@RestController
@RequestMapping("/api/players/addresses")
public class PlayerAddressController extends CrudController<PlayerAddress, Long, PlayerAddressService> {

    @Autowired
    public PlayerAddressController(PlayerAddressService playerAddressService) {
        super(playerAddressService);
    }
}
