package org.hse.robowar.remote;

import org.hse.robowar.dto.FightRequestDTO;
import org.hse.robowar.dto.FightResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "python", url = "${python_url}")
public interface PythonRMI {

    @PostMapping("/fight")
    FightResponseDTO getFightResponseDTO(@RequestBody FightRequestDTO fightRequestDTO);
}
