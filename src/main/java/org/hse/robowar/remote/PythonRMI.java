package org.hse.robowar.remote;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "python", url = "${python_url}")
public interface PythonRMI {
}
