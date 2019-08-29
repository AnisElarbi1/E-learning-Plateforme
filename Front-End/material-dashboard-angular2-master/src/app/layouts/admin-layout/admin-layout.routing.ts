import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';

import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import { ProfilComponent } from 'app/profil/profil.component';
import { InscriptionComponent } from 'app/inscription/inscription.component';
import { AddpubComponent } from 'app/addpub/addpub.component';
import { PublicationComponent } from 'app/publication/publication.component';
import { AjoutensComponent } from 'app/ajoutens/ajoutens.component';

export const AdminLayoutRoutes: Routes = [
   
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent },
    { path: 'table-list',     component: TableListComponent },
    { path: 'typography',     component: TypographyComponent },
    { path: 'icons',          component: IconsComponent },
    { path: 'notifications',  component: NotificationsComponent },
    { path: 'upgrade',        component: UpgradeComponent },
    { path: 'addpubs',        component: AddpubComponent},
    { path: 'publication',        component: PublicationComponent},
    { path: 'addens',         component: AjoutensComponent }

];
