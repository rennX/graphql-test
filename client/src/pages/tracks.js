import React from 'react';
import { Layout } from '../components';
import { gql } from '@apollo/client';

export const TRACKS = gql`
  query getTracks {
    tracksForHome {
      id
      title
      author {
        name
        photo
        id
      }
      thumbnail
      length
      modulesCount
    }
  }
`

/**
 * Tacks Page is Catstronauts home page.
 * We display a grid of tracks fetched with useQuery with the TRACKS query
 */
const Tracks = () => {
  return <Layout grid> </Layout>;
};

export default Tracks;
