/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.tsunami.main.cli.option;

import static org.junit.Assert.assertThrows;

import com.beust.jcommander.ParameterException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link ScanTargetCliOptions}. */
@RunWith(JUnit4.class)
public class ScanTargetCliOptionsTest {

  @Test
  public void validate_whenMissingScanTarget_throwsParameterException() {
    ScanTargetCliOptions cliOptions = new ScanTargetCliOptions();

    assertThrows(ParameterException.class, cliOptions::validate);
  }

  @Test
  public void validate_whenMultipleScanTargets_throwsParameterException() {
    ScanTargetCliOptions cliOptions = new ScanTargetCliOptions();
    cliOptions.ipV4Target = "127.0.0.1";
    cliOptions.ipV6Target = "2002:af4:9b91::";

    assertThrows(ParameterException.class, cliOptions::validate);
  }
}
