package org.hse.robowar.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.model.Account;
import org.hse.robowar.model.ArmorEquipment;
import org.hse.robowar.model.Robot;
import org.hse.robowar.repository.AccountRepository;
import org.hse.robowar.repository.ArmorEquipmentRepository;
import org.hse.robowar.repository.RobotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopServiceImpl implements ShopService {

    private final RobotRepository robotRepository;
    private final AccountRepository accountRepository;
    private final ArmorEquipmentRepository armorEquipmentRepository;

    @Transactional
    @Override
    public void buyArmorEquipment(UUID robotId, UUID armorId) {
        Robot robot = robotRepository.findById(robotId)
                .orElseThrow(() -> new IllegalArgumentException("Robot with id: " + robotId.toString() + "is not exist"));
        Account account = robot.getAccount();
        ArmorEquipment armorEquipment = armorEquipmentRepository.findById(armorId)
                .orElseThrow(() -> new IllegalArgumentException("Armor equipment with id: " + armorId.toString() + "is not exist"));
        if (armorEquipment.getCost() > account.getMoney()) {
            throw new IllegalArgumentException("Not enough money on account");
        }
        account.setMoney(account.getMoney()-armorEquipment.getCost());
        accountRepository.save(account);
        robot.getArmorEquipmentList().add(armorEquipment);
        robotRepository.save(robot);
    }
}
