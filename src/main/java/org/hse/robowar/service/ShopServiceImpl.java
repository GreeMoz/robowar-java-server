package org.hse.robowar.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hse.robowar.model.*;
import org.hse.robowar.repository.*;
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
    private final CombatEquipmentRepository combatEquipmentRepository;
    private final MovementEquipmentRepository movementEquipmentRepository;

    @Transactional
    @Override
    public void buyArmorEquipment(UUID robotId, UUID armorId) {
        Robot robot = existRobot(robotId);
        Account account = robot.getAccount();
        ArmorEquipment armorEquipment = armorEquipmentRepository.findById(armorId)
                .orElseThrow(() -> new IllegalArgumentException("Armor equipment with id: " + armorId.toString() + "is not exist"));
        checkMoney(armorEquipment.getCost(), account.getMoney());
        account.setMoney(account.getMoney() - armorEquipment.getCost());
        accountRepository.save(account);
        robot.getArmorEquipmentList().add(armorEquipment);
        robotRepository.save(robot);
    }

    @Override
    public void buyCombatEquipment(UUID robotId, UUID combatId) {
        Robot robot = existRobot(robotId);
        Account account = robot.getAccount();
        CombatEquipment combatEquipment = combatEquipmentRepository.findById(combatId)
                .orElseThrow(() -> new IllegalArgumentException("Armor equipment with id: " + combatId.toString() + "is not exist"));
        checkMoney(combatEquipment.getCost(), account.getMoney());
        account.setMoney(account.getMoney() - combatEquipment.getCost());
        accountRepository.save(account);
        robot.getCombatEquipmentList().add(combatEquipment);
        robotRepository.save(robot);
    }

    @Override
    public void buyMovementEquipment(UUID robotId, UUID movementId) {
        Robot robot = existRobot(robotId);
        Account account = robot.getAccount();
        MovementEquipment movementEquipment = movementEquipmentRepository.findById(movementId)
                .orElseThrow(() -> new IllegalArgumentException("Armor equipment with id: " + movementId.toString() + "is not exist"));
        checkMoney(movementEquipment.getCost(), account.getMoney());
        account.setMoney(account.getMoney() - movementEquipment.getCost());
        accountRepository.save(account);
        robot.getMovementEquipmentList().add(movementEquipment);
        robotRepository.save(robot);
    }

    private Robot existRobot(UUID robotId) {
        return robotRepository.findById(robotId)
                .orElseThrow(() -> new IllegalArgumentException("Robot with id: " + robotId.toString() + "is not exist"));
    }

    private void checkMoney(int cost, int money) {
        if (cost > money) {
            throw new IllegalArgumentException("Not enough money on account");
        }
    }
}
