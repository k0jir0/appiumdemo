/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.appium.java_client.android.options.server;

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.remote.options.CanSetCapability;
import org.openqa.selenium.Capabilities;

import java.time.Duration;
import java.util.Optional;

import static io.appium.java_client.internal.CapabilityHelpers.toDuration;

public interface SupportsEspressoServerLaunchTimeoutOption<T extends BaseOptions<T>> extends
        Capabilities, CanSetCapability<T> {
    String ESPRESSO_SERVER_LAUNCH_TIMEOUT_OPTION = "espressoServerLaunchTimeout";

    /**
     * Set the maximum timeout to wait util Espresso  is listening on the device.
     * 45000 ms by default
     *
     * @param timeout Timeout value.
     * @return self instance for chaining.
     */
    default T setUiautomator2ServerInstallTimeout(Duration timeout) {
        return amend(ESPRESSO_SERVER_LAUNCH_TIMEOUT_OPTION, timeout.toMillis());
    }

    /**
     * Get the maximum timeout to wait until Espresso server is listening on the device.
     *
     * @return The timeout value.
     */
    default Optional<Duration> getUiautomator2ServerInstallTimeout() {
        return Optional.ofNullable(
                toDuration(getCapability(ESPRESSO_SERVER_LAUNCH_TIMEOUT_OPTION))
        );
    }
}
