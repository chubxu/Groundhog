import axios from 'axios';

export interface BaseInfoModel {
  recordTemplateName: string;
  recordTemplateDescription: string;
  recordTime: string;
}
export interface ChannelInfoModel {
  httpInterface: string;
  httpInterfaceSampleRate: string;
  dubboInterface: string;
  dubboInterfaceSampleRate: string;
}

export type UnitChannelModel = BaseInfoModel & ChannelInfoModel;

export function submitChannelForm(data: UnitChannelModel) {
  return axios.post('/api/channel-form/submit', { data });
}
