/**
 * Copyright (c) 2019. PT. Distributor Indonesia Unggul. All rights reserverd.
 *
 * This source code is an unpublished work and the use of  a copyright  notice
 * does not imply otherwise. This source  code  contains  confidential,  trade
 * secret material of PT. Distributor Indonesia Unggul.
 * Any attempt or participation in deciphering, decoding, reverse  engineering
 * or in any way altering the source code is strictly  prohibited, unless  the
 * prior  written consent of Distributor Indonesia Unggul. is obtained.
 *
 * Unless  required  by  applicable  law  or  agreed  to  in writing, software
 * distributed under the License is distributed on an "AS IS"  BASIS,  WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or  implied.  See  the
 * License for the specific  language  governing  permissions  and limitations
 * under the License.
 *
 * Author : Bobby
 */

package test.authentication;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import test.authentication.services.StartUpListener;

import javax.inject.Singleton;

@Singleton
public class Application implements ApplicationEventListener<ServerStartupEvent> {
    private final StartUpListener startUpListener;

    public Application(StartUpListener startUpListener) {
        this.startUpListener = startUpListener;
    }


    public static void main(String[] args) {
        Micronaut.run(Application.class);

//        Micronaut.build(args)
//                .packages("test.authentication.domain")
//                .mainClass(Application.class)
//                .start();


    }


    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        try {
            startUpListener.CheckUserToInsert();
            startUpListener.CheckRoleToInsert();
            startUpListener.CheckUserRoleToInsert();
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}