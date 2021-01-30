import React from 'react';
import { Layout } from '../components';
import { gql, useQuery } from '@apollo/client';

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
  const { loading, error, data } = useQuery(TRACKS);

  if (loading) return `Loading...`;

  if (error) return `Error! ${error.message}`;

  return <Layout grid>
    {JSON.stringify(data)}
  </Layout>;
};

export default Tracks;
