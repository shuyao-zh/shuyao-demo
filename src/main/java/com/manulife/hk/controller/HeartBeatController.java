package com.manulife.hk.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import strman.Strman;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Objects;

/**
 * Heart Beat Controller
 *
 * @author jeffreyli
 * @date 2021-04-30
 */

@RestController
@Api(tags = "Utils")
@Slf4j
public class HeartBeatController {

    @GetMapping("beat")
    public ResponseEntity<String> beat() {
        String hostAddress = Objects.requireNonNull(getLocalHostExactAddress()).getHostAddress();
        String result = Strman.format("{0} is alive", hostAddress);
        log.info(result);
        return ResponseEntity.ok(result);
    }

    public static InetAddress getLocalHostExactAddress() {
        try {
            InetAddress candidateAddress = null;

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface iface = networkInterfaces.nextElement();
                for (Enumeration<InetAddress> inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {
                        if (inetAddr.isSiteLocalAddress()) {
                            return inetAddr;
                        }
                        if (candidateAddress == null) {
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            return candidateAddress == null ? InetAddress.getLocalHost() : candidateAddress;
        } catch (Exception e) {
            log.error("Get local host exact address exception", e);
        }
        return null;
    }
}
